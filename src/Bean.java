import java.util.ArrayList;

class Bean {
    static ArrayList<Point> table = new ArrayList<>();

    static String printPoints() {
        StringBuilder data = new StringBuilder();
        for (Point p : table)
            data.append(printPoint(p));
        return data.toString();
    }

    static String printPoint(Point p) {
        return "<tr>" +
                "<td>" +
                String.format("%.2f", p.x) +
                "</td>" +
                "<td>" +
                String.format("%.2f", p.y) +
                "</td>" +
                "<td>" +
                String.format("%.2f", p.R) +
                "</td>" +
                "<td>" +
                (p.isInArea ? "Yes" : "No") +
                "</td>" +
                "</tr>";
    }
}