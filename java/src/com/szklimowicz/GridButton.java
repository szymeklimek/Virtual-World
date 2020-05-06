package com.szklimowicz;

import javax.swing.*;

public class GridButton extends JButton {

   private Field field;

   public GridButton(Field field) {
       this.field = field;
   }

    public Field getField() {
        return field;
    }
}
