package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableColumn;

public class test1 {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("JTable with Checkbox");

        // Dữ liệu mẫu
        Object[][] data = {
                {"1", "John", "Doe", false},
                {"2", "Jane", "Smith", true},
                {"3", "Bob", "Johnson", false},
                {"4", "Alice", "Williams", true},
                {"5", "Mark", "Brown", false},
                {"6", "Sarah", "Jones", true},
                {"7", "Michael", "Davis", false},
                {"8", "Emily", "Miller", true},
                {"9", "David", "Wilson", false},
                {"10", "Emma", "Taylor", true}
        };

        // Tiêu đề cột
        Object[] columnNames = {"ID", "First Name", "Last Name", "Active"};

        // Tạo một DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Tạo một JTable với DefaultTableModel
        JTable table = new JTable(model);

        // Thêm checkbox vào cột "Active"
        TableColumn activeColumn = table.getColumnModel().getColumn(3);
        activeColumn.setCellRenderer(new CheckBoxRenderer());
        activeColumn.setCellEditor(new CheckBoxEditor());

        // Thêm bảng vào JFrame
        frame.add(new JScrollPane(table));

        // Cài đặt kích thước, hiển thị và chế độ đóng cửa sổ
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Lớp để hiển thị checkbox trong bảng
    static class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        CheckBoxRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            setSelected((value != null && ((Boolean) value)));
            return this;
        }
    }

    // Lớp để chỉnh sửa checkbox trong bảng
    static class CheckBoxEditor extends DefaultCellEditor {
        CheckBoxEditor() {
            super(new JCheckBox());
        }
    }
}
