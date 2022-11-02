
package basicediting;

public class Editing {

    private String fieldFoo;

    private static final String A_CONSTANT = "a constant with multiple " +
            "words on multiple" +
            " lines";

    public String getFieldFoo() {
        return fieldFoo;
    }

    public void append(String bar) {
        this.fieldFoo += bar;
        if (bar.length() > 3) {
            this.fieldFoo = "meh";
        }
    }

}
