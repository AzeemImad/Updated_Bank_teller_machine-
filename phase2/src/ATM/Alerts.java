package ATM;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Alerts {
    /**String List that contains alerts from the previous day*/
    private List<String> previousAlerts;

    /**String List that contains alerts form the current day*/
    private List<String> todayAlerts = new ArrayList<>();

    public Alerts(List<String> list){
        if (list != null){
            previousAlerts = list;
        } else {
            previousAlerts = new ArrayList<>();
        }
    }

    public void addAlert(String message){
        todayAlerts.add("- " + message);
    }

    List<String> writeOutAlerts(){
        return todayAlerts;
    }

    public JList<String> getYesterdayAlerts(){
        DefaultListModel<String> yesterdayList = new DefaultListModel<>();
        for (String alert : previousAlerts){
            yesterdayList.addElement(alert);
        }
        return new JList<>(yesterdayList);
    }

    public JList<String> getTodayAlerts(){
        DefaultListModel<String> todayList = new DefaultListModel<>();
        for (String alert : todayAlerts){
            todayList.addElement(alert);
        }
        return new JList<>(todayList);
    }
}
