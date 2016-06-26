import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by erreil on 25.06.16.
 */


public class RESTClient {


    public static void main(String[] args){

        String baseUrl = "http://localhost:8080/WholesalerWebDemo";

        Client client = ClientBuilder.newClient();

        //Export Product Catalog
        Response res = client.target(baseUrl + "/rest/ExportProductCatalog/")
                .request(MediaType.TEXT_PLAIN)
                .get();

        String response = res.readEntity(String.class);
        System.out.println(response);



        // Import Product Catalog
        String importXml = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                "<BMECAT version=\"1.2\">\n" +
                "\t<HEADER>\n" +
                "\t\t<CATALOG>\n" +
                "\t\t\t<LANGUAGE>deu</LANGUAGE>\n" +
                "\t\t\t<CATALOG_ID>FHKN-EBUS-WS0405</CATALOG_ID>\n" +
                "\t\t\t<CATALOG_VERSION>1.0</CATALOG_VERSION>\n" +
                "\t\t\t<CATALOG_NAME>Beispielproduktkatalog für E-Business Laborpraktikum</CATALOG_NAME>\n" +
                "\t\t\t<CURRENCY>EUR</CURRENCY>\n" +
                "\t\t</CATALOG>\n" +
                "\t\t<BUYER>\n" +
                "\t\t\t<BUYER_NAME>Student AG</BUYER_NAME>\n" +
                "\t\t</BUYER>\n" +
                "\t\t<SUPPLIER>\n" +
                "\t\t\t<SUPPLIER_NAME>Wäsch Global Industries</SUPPLIER_NAME>\n" +
                "\t\t</SUPPLIER>\n" +
                "\t</HEADER>\n" +
                "\t<T_NEW_CATALOG prev_version=\"0\">\n" +
                "\t\t<ARTICLE>\n" +
                "\t\t\t<SUPPLIER_AID>A1113</SUPPLIER_AID>\n" +
                "\t\t\t<ARTICLE_DETAILS>\n" +
                "\t\t\t\t<DESCRIPTION_SHORT>Bleistift HB</DESCRIPTION_SHORT>\n" +
                "\t\t\t\t<DESCRIPTION_LONG>Der Bleistift für alle Zwecke</DESCRIPTION_LONG>\n" +
                "\t\t\t\t<EAN>99999991</EAN>\n" +
                "\t\t\t\t<BUYER_AID type=\"LNR\">4711</BUYER_AID>\n" +
                "\t\t\t</ARTICLE_DETAILS>\n" +
                "\t\t\t<ARTICLE_ORDER_DETAILS>\n" +
                "\t\t\t\t<ORDER_UNIT>PK</ORDER_UNIT>\n" +
                "\t\t\t\t<CONTENT_UNIT>C62</CONTENT_UNIT>\n" +
                "\t\t\t\t<NO_CU_PER_OU>10</NO_CU_PER_OU>\n" +
                "\t\t\t</ARTICLE_ORDER_DETAILS>\n" +
                "\t\t\t<ARTICLE_PRICE_DETAILS>\n" +
                "\t\t\t\t<ARTICLE_PRICE price_type=\"net_list\">\n" +
                "\t\t\t\t\t<PRICE_AMOUNT>2.99</PRICE_AMOUNT>\n" +
                "\t\t\t\t\t<PRICE_CURRENCY>EUR</PRICE_CURRENCY>\n" +
                "\t\t\t\t\t<TERRITORY>DE</TERRITORY>\n" +
                "\t\t\t\t\t<TERRITORY>AT</TERRITORY>\n" +
                "\t\t\t\t</ARTICLE_PRICE>\n" +
                "\t\t\t\t<ARTICLE_PRICE price_type=\"net_list\">\n" +
                "\t\t\t\t\t<PRICE_AMOUNT>4.99</PRICE_AMOUNT>\n" +
                "\t\t\t\t\t<PRICE_CURRENCY>USD</PRICE_CURRENCY>\n" +
                "\t\t\t\t\t<TERRITORY>US</TERRITORY>\n" +
                "\t\t\t\t</ARTICLE_PRICE>\n" +
                "\t\t\t</ARTICLE_PRICE_DETAILS>\n" +
                "\t\t</ARTICLE>\n" +
                "\t</T_NEW_CATALOG>\n" +
                "</BMECAT>";

        Response res2 = client.target(baseUrl +"/rest/ImportProductCatalog").request(MediaType.APPLICATION_XML).post(Entity.entity(importXml, MediaType.APPLICATION_XML));
        String response2 = res2.readEntity(String.class);
        System.out.println(response2);
    }
}
