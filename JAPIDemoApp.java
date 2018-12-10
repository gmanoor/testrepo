import com.ibm.pim.catalog.Catalog;
import com.ibm.pim.catalog.CatalogManager;
import com.ibm.pim.context.Context;
import com.ibm.pim.context.PIMContextFactory;
import com.ibm.pim.spec.Spec;
import com.ibm.pim.spec.SpecManager;

public class JAPIDemoApp
{
    public static void main(String[] args)
    {
        Context ctx = null;
        try
        {
	     //Obtain the context
            ctx = PIMContextFactory.getContext("user", "password", "MyCompany");
            System.out.println("Context" + ctx.toString());

	     //Create a Spec object for an pre-existing spec “Test Spec”
            SpecManager specMgr = ctx.getSpecManager();
            Spec spec = specMgr.getSpec("Test Spec");

	     //Load a pre-existing catalog in the system.
            CatalogManager ctgManager = ctx.getCatalogManager();
            Catalog ctg = ctgManager.getCatalog("WS Catalog1");

            ctx.cleanUp();

            System.exit(0);
        }
        catch (Exception e)
        {
	     //If any exception is encountered, print the stack trace and
		//a message
            e.printStackTrace();
            System.out.println(“JAPIDemoApp failed");
        }
    }
}
