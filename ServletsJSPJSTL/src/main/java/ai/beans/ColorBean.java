package ai.beans;

public class ColorBean {

    private String foregroundColor;
    private String backgroundColor;
    private String borderStyle;

    public ColorBean() {
    }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the borderStyle
     */
    public String getBorderStyle() {
        return borderStyle;
    }

    /**
     * @param borderStyle the borderStyle to set
     */
    public void setBorderStyle(String borderStyle) {
        if(borderStyle.equals("tak")) this.borderStyle = "solid";
        else this.borderStyle = "none";
    }
}
