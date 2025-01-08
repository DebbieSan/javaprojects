/**
 * A program to generate and print mailing labels for all your old school letter
 * needs.
 */

public class ShippingLabel {

    private MailingAddress shipFrom;
    private MailingAddress shipTo;

    public ShippingLabel(MailingAddress shipFrom, MailingAddress shipto) {
        this.shipFrom = shipFrom;
        this.shipTo = shipto;
    }

    public void labelPrinter() {
        ShippingLabel label = new ShippingLabel(shipFrom, shipTo);
        System.out.println(label);
    }

    @Override
    public String toString() {
        return "Generating Shipping Label...\n " + "From >>>>>" + shipFrom
                + " " + "\n To >>>>> " + shipTo;
    }

    public static void main(String[] args) {

        FullName person1 = new FullName("Cathy", "Cat", "Catherine", "Ms");
        MailingAddress add1 = new MailingAddress(person1, "1234 Kitty Way", "Meowville", "Ontario", "M6E0x0");

        FullName person2 = new FullName("Mike", "Mice", "Ratty", "Mr.");
        MailingAddress add2 = new MailingAddress(person2, "5678 Mazy boulevard", "MouseLand", "British Columbia",
                "V1M3O3");

        ShippingLabel label1 = new ShippingLabel(add1, add2);

        System.out.println(label1);

        System.out.println("Label Printed.");
    }

}
