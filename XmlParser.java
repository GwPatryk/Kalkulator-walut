import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlParser{
    private static final String FILENAME = "eurofxref-daily.xml";
    public static String[] currencyList;

    //Constructor reading all the currency from file to give the list to combobox
    public XmlParser() {
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            //parse file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("Cube");
            
            // Reading all the currency from file
            currencyList = new String[list.getLength()-2];
            String currencyName;
            String currencyMultiplier;
            for(int i = 2 ; i < list.getLength() ; i++){
                currencyName = list.item(i).getAttributes().getNamedItem("currency").toString().split("\"")[1];
                currencyMultiplier = list.item(i).getAttributes().getNamedItem("rate").toString().split("\"")[1];
                currencyList[i-2] = currencyName + " - " + currencyMultiplier;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float parseForMultiplier(String currency) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            //parse file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("Cube");
            
            //looking for a row in the file that has our currency in it and getting the multiplier when found
            String[] str;
            for(int i = 2 ; i < list.getLength() ; i++){
                str = list.item(i).getAttributes().getNamedItem("currency").toString().split("\"");
                if(currency.equals(str[1])){
                    return Float.parseFloat(list.item(i).getAttributes().getNamedItem("rate").toString().split("\"")[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}