package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    /**
     * registrer og gemmer indtastede commands fra en bruger eller medarbejder.
     */

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login() );
        commands.put("register", new Register() );
        commands.put("quickByg", new QuickByg() );
        commands.put("nav", new Navigation() );
        commands.put("stykliste", new LavStykListe());
        commands.put("sletMateriale", new SletMateriale());
        commands.put("lægIkurv", new TilføjTilKurv());
        commands.put("sletOrdre", new SletOrdre());
        commands.put("notification", new Notificationer());
        commands.put("filter", new KatalogFilter());
        commands.put("sletBruger", new SletBruger());
        commands.put("sendstkliste", new SendStykListe());
        commands.put("productpage", new productPage());

    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException;

}
