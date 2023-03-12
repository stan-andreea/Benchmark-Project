import javax.swing.*;
import java.awt.event.ActionListener;

public class Benchmark extends JFrame {
    private JPanel mainPanel;
    private JButton staticMemoryAllocationButton;
    private JButton dynamicMemoryAllocationButton;
    private JButton staticMemoryAccessButton;
    private JButton dynamicMemoryAccessButton;
    private JButton threadCreationButton;
    private JButton threadContextSwitchButton;
    private JButton threadMigrationButton;
    private JTextField threadMigrationPythonText;
    private JTextField threadContextSwitchPythonText;
    private JTextField threadCreationPythonText;
    private JTextField dynamicMemoryAccessPythonText;
    private JTextField staticMemoryAccessPythonText;
    private JTextField dynamicMemoryAllocationPythonText;
    private JTextField staticMemoryAllocationPythonText;
    private JTextField staticMemoryAllocationCText;
    private JTextField staticMemoryAllocationJavaText;
    private JTextField dynamicMemoryAllocationCText;
    private JTextField dynamicMemoryAllocationJavaText;
    private JTextField staticMemoryAccessCText;
    private JTextField staticMemoryAccessJavaText;
    private JTextField dynamicMemoryAccessCText;
    private JTextField dynamicMemoryAccessJavaText;
    private JTextField threadCreationCText;
    private JTextField threadCreationJavaText;
    private JTextField threadContextSwitchCText;
    private JTextField threadContextSwitchJavaText;
    private JTextField threadMigrationCText;
    private JTextField threadMigrationJavaText;

    public Benchmark() {
        setTitle("Benchmark");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public void addStaticMemoryAllocationBtnListener(ActionListener a) {
        staticMemoryAllocationButton.addActionListener(a);
    }

    public void addDynamicMemoryAllocationBtnListener(ActionListener a) {
        dynamicMemoryAllocationButton.addActionListener(a);
    }

    public void addStaticMemoryAccessBtnListener(ActionListener a) {
        staticMemoryAccessButton.addActionListener(a);
    }

    public void addDynamicMemoryAccessBtnListener(ActionListener a) {
        dynamicMemoryAccessButton.addActionListener(a);
    }

    public void addThreadCreationBtnListener(ActionListener a) {
        threadCreationButton.addActionListener(a);
    }

    public void addThreadContextSwitchBtnListener(ActionListener a) {
        threadContextSwitchButton.addActionListener(a);
    }

    public void addThreadMigrationBtnListener(ActionListener a) {
        threadMigrationButton.addActionListener(a);
    }

    public void setThreadCreationText(String cValue, String javaValue, String pythonValue) {
        threadCreationCText.setText(cValue);
        threadCreationJavaText.setText(javaValue);
        threadCreationPythonText.setText(pythonValue);
    }

    public void setThreadContextSwitchText(String cValue, String javaValue, String pythonValue) {
        threadContextSwitchCText.setText(cValue);
        threadContextSwitchJavaText.setText(javaValue);
        threadContextSwitchPythonText.setText(pythonValue);
    }

    public void setThreadMigrationText(String cValue, String javaValue, String pythonValue) {
        threadMigrationCText.setText(cValue);
        threadMigrationJavaText.setText(javaValue);
        threadMigrationPythonText.setText(pythonValue);
    }

    public void setStaticMemoryAllocationText(String cValue, String javaValue, String pythonValue) {
        staticMemoryAllocationCText.setText(cValue);
        staticMemoryAllocationJavaText.setText(javaValue);
        staticMemoryAllocationPythonText.setText(pythonValue);
    }

    public void setDynamicMemoryAllocationText(String cValue, String javaValue, String pythonValue) {
        dynamicMemoryAllocationCText.setText(cValue);
        dynamicMemoryAllocationJavaText.setText(javaValue);
        dynamicMemoryAllocationPythonText.setText(pythonValue);
    }

    public void setStaticMemoryAccessText(String cValue, String javaValue, String pythonValue) {
        staticMemoryAccessCText.setText(cValue);
        staticMemoryAccessJavaText.setText(javaValue);
        staticMemoryAccessPythonText.setText(pythonValue);
    }

    public void setDynamicMemoryAccessText(String cValue, String javaValue, String pythonValue) {
        dynamicMemoryAccessCText.setText(cValue);
        dynamicMemoryAccessJavaText.setText(javaValue);
        dynamicMemoryAccessPythonText.setText(pythonValue);
    }
}
