package Data;

import java.awt.Component;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class IconListRenderer extends JLabel implements ListCellRenderer {
   private JLabel label;
 
   public Component getListCellRendererComponent(JList list, Object value,
                                                 int index, boolean isSelected,
                                                 boolean cellHasFocus) {
      IconList entry = (IconList) value;
 
      setText(value.toString());
      setIcon(entry.getIcon());
  
      if (isSelected) {
         setBackground(list.getSelectionBackground());
         setForeground(list.getSelectionForeground());
      }
      else {
         setBackground(list.getBackground());
         setForeground(list.getForeground());
      } 
 
      setEnabled(list.isEnabled());
      setFont(list.getFont());
      setOpaque(true);
 
      return this;
   }
}
