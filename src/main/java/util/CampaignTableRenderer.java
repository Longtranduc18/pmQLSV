package util;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CampaignTableRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        String campaignType = table.getValueAt(row, 0).toString();
        
        if (campaignType.equals("CSVH")) {
            c.setBackground(Color.GREEN);
        } else if (campaignType.equals("CSHP")) {
            c.setBackground(Color.ORANGE);
        } else if (campaignType.equals("CS1D3")) {
            c.setBackground(Color.YELLOW);
        } else {
            c.setBackground(Color.GRAY);
        }
        
        return c;
    }
    
}
