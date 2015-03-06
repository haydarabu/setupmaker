package dcp.gui.pivot.validators;

import org.apache.pivot.wtk.validation.Validator;

import dcp.logic.factory.TypeFactory.LOG_LEVEL;
import dcp.main.log.Out;


public class URLValidator implements Validator
{
    
    @Override
    public boolean isValid(String url)
    {
        if ("http://".startsWith(url) || "https://".startsWith(url))
            return true;
        if (url.equals("") ||
                url.startsWith("http://") || url.startsWith("https://"))
            return true;
        
        Out.print(LOG_LEVEL.DEBUG, "URL format incorrect: " + url);
        return false;
    }

}
