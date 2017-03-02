package csci3130.email_validatorUI;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        Email email=new Email("");
        final TextField name = new TextField();
        name.setCaption("Whats your email?");

        Button button = new Button("Submit");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks, Your Email: " + name.getValue() 
                    ));
            
            email.email=name.getValue();
            String output = "";
            boolean isValid=true;
            if(email.atSign()==false)
            {
            	output="There is no @ sign!		";
            	isValid=false;
            }
            
            if(email.lengthCheck()==false)
            {
            	output+="Email is too long!		";
            	isValid=false;
            }
            
            if(email.period()==false)
            {
            	output+="There is no . character!		";
            	isValid=false;
            }
            
            if(email.spaceCheck()==true)
            {
            	output+="Email has a space!		";
            	isValid=false;
            }
            
            if(isValid==true)
            {
            	output="Email is valid!";
            }
            
            else output+="Email is invalid!";
            
            
            
            layout.addComponent(new Label(output));
        });
      
        
        layout.addComponents(name, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
