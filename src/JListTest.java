import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JListTest extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> jList;
    private JButton addButton;

    public JListTest() {
        // 윈도우 초기화
        setTitle("JList Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // 리스트 모델 생성
        listModel = new DefaultListModel<>();

        // JList 생성 및 모델 설정
        jList = new JList<>(listModel);

        // JScrollPane을 이용하여 JList를 감싸기
        JScrollPane scrollPane = new JScrollPane(jList);
        add(scrollPane);

        // 추가 버튼 생성 및 이벤트 핸들러 등록
        addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        // 프레임에 버튼 추가
        add(addButton, "South");

        // 윈도우 표시
        setVisible(true);
    }

    private void addItem() {
        String newItem = JOptionPane.showInputDialog("Enter item:");
        if (newItem != null && !newItem.trim().isEmpty()) {
            // 리스트 모델에 항목 추가
            listModel.addElement(newItem);
        }
    }

    public static void main(String[] args) {
        // GUI 이벤트 디스패치 스레드에서 실행
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JListTest();
            }
        });
    }
}
