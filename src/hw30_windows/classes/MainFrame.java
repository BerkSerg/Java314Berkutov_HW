package hw30_windows.classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JList<String> listNames;
    private JList<String> listInfo;
    private JLabel topLabel;
    private DataBase db;

    public MainFrame(String title) throws HeadlessException {
        super(title);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        JPanel panelTop = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelLeft = new JPanel();

        mainPanel.add(panelTop, BorderLayout.NORTH);
        panelTop.setPreferredSize(new Dimension(800, 100));

        panelTop.setBackground(Color.LIGHT_GRAY);

        mainPanel.add(panelRight, BorderLayout.CENTER);

        mainPanel.add(panelLeft, BorderLayout.WEST);
        panelLeft.setPreferredSize(new Dimension(400, 500));
        panelLeft.setBackground(Color.GRAY);

        listNames = new JList<>();
        listNames.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !listNames.isSelectionEmpty()) {
                Object element = listNames.getSelectedValue();
                System.out.println();
                findAndFill(element.toString());
            }
        });

        JScrollPane scrollListNames = new JScrollPane(listNames);
        scrollListNames.setPreferredSize(new Dimension(380, 400));
        panelLeft.add(scrollListNames);


        listInfo = new JList<>();
        JScrollPane scrollListInfo = new JScrollPane(listInfo);
        scrollListInfo.setPreferredSize(new Dimension(380, 400));
        panelRight.add(scrollListInfo);

        topLabel = new JLabel("");
        panelTop.add(topLabel);
    }


    public void initLeftList() {
        listNames.setListData(db.getNames());
    }

    private void updateRightList(Hospital hospital) {
        ArrayList<String> infoList = hospital.getTypeOfHelping();
        String[] info = new String[infoList.size()];
        infoList.toArray(info);
        listInfo.setListData(info);
    }

    private void findAndFill(String hospitalName) {
        Hospital hospital = db.getHospitalByName(hospitalName);
        updateRightList(hospital);
        topLabel.setText("<html>"+hospital.getName()+"<br/"+hospital.getAddress()+"<br/>"+hospital.getPhone()+"</html");
    }


    public void connectToDb(DataBase db) {
        this.db = db;
    }
}
