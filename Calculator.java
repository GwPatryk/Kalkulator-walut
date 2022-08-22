import java.text.DecimalFormat;

public class Calculator{

    //Returns result of (input value in EUR)*(currency multiplier from xml file) as String
    public String calculate(float inputEuroValue, String currency){
        XmlParser parser = new XmlParser();
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(inputEuroValue * parser.parseForMultiplier(currency));
    }
}