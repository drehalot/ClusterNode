package charts;

import java.util.ArrayList;

public class Chart {

    private String title;

    private ArrayList<ChartData> data;

    public Chart(String title, ArrayList<ChartData> data) {
        this.title = title;
        this.data = data;
    }

    public Chart(ArrayList<ChartData> data) {
        this.title = ChartStaticValues.TITLE_DEFAULT_VALUE;
        this.data = data;
    }

    public StringBuilder getChart() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE HTML>\n<html>\n<head>\n<script>window.onload = function () {\n");
        stringBuilder.append("\n var chart = new CanvasJS.Chart(\"chartContainer\", {\n\tanimationEnabled: true,\n" +
                "\ttheme: \"light2\"\n\t, title: {\n");
        stringBuilder.append("text: \"" + title + "\"\n},");
        stringBuilder.append("\t\tzoomEnabled: true,\n" +
                "\t\texportEnabled: true,");
        stringBuilder.append("\taxisY: {\n\t\ttitle: \"" + ChartStaticValues.AXIS_Y + "\" }, ");
        stringBuilder.append("\taxisX: {\n\t\ttitle: \"" + ChartStaticValues.AXIS_X + "\" }, ");
        stringBuilder.append("\tdata: [{\n" +
                "\t\ttype: \"column\",  \n" +
                "\t\tlegendMarkerColor: \"grey\"," +
                "\t\ttoolTipContent: \" Node with name  <br> <b>{label}</b> </br> has integral parameter <br> <b>{y}</b> </br> \"," +
                "\t\tdataPoints: [\n"
                + getTransferData(data) +
                "\t\t\t\n" +
                "\t\t]\n" +
                "\t}]\n" +
                "});\n" +
                "chart.render();\n" +
                "\n" +
                "}\n" +
                "</script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"chartContainer\" style=\"height: 370px; width: 100%;\"></div>\n" +
                "<script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
                "</body>\n" +
                "</html>");
        return stringBuilder;
    }

    private String getTransferData(ArrayList<ChartData> data) {
        if (data != null && data.size() > 0) {
            return data.toString().substring(1, data.toString().length() - 1);
        }
        return new ChartData("No any data", -1).toString();
    }


}
