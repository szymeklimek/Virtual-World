package com.szklimowicz;

import com.szklimowicz.organisms.Organism;
import com.szklimowicz.organisms.plants.*;
import com.szklimowicz.organisms.animals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameSetup {

    private static World world = new World(MyConsts.WORLD_X, MyConsts.WORLD_Y);
    private static int specialCounter = 0;
    private static int turnCounter = 1;
    private static List<GridButton> gridButtons = new ArrayList<>();

    static {

        ActionListener gridButtonsListener = GameSetup::onGridClick;

        for(int i = 0; i < world.getFields().length; i++) {
            for (int j = 0; j < world.getFields()[i].length; j++) {
                world.getFields()[i][j] = new Field(j, i, null);
                GridButton tempButton = new GridButton(world.getFields()[i][j]);
                tempButton.setBorder(null);
                tempButton.setMargin(new Insets(0, 0, 0, 0));
                tempButton.setIcon(MyConsts.NULL_SPRITE);
                tempButton.addActionListener(gridButtonsListener);
                gridButtons.add(tempButton);
            }
        }
    }

    private GameSetup(){};

    private static void guiSetup() {

        JFrame mainFrame = new JFrame("Virtual World");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel sidePanel = new JPanel(new BorderLayout());

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton abilityButton = new JButton("Activate Ability");
        abilityButton.addActionListener(new AbilityButtonListener());
        buttonBox.add(abilityButton);

        buttonBox.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton nextTurnButton = new JButton("Next Turn");
        nextTurnButton.addActionListener(new TurnButtonListener());
        buttonBox.add(nextTurnButton);

        GridLayout grid = new GridLayout(world.getY(), world.getX());
        grid.setHgap(1);
        grid.setVgap(1);
        JPanel gridPanel = new JPanel(grid);

        for(GridButton gb : gridButtons) {
            gridPanel.add(gb);
        }

        sidePanel.add(BorderLayout.NORTH, buttonBox);
        mainPanel.add(BorderLayout.EAST, sidePanel);
        mainPanel.add(BorderLayout.CENTER, gridPanel);
        mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        //mainFrame.setSize(800,600);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    static class AbilityButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doTurn();
            drawOrganisms();
            System.out.println("Ability Used!");
        }
    }

    static class TurnButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doTurn();
            drawOrganisms();
            System.out.println("Turn Passed!");
        }
    }

    private static void onGridClick(ActionEvent event) {
        GridButton gb = (GridButton) event.getSource();
        JFrame mainFrame = (JFrame) SwingUtilities.getRoot(gb);
        JPanel dialogPanel = new JPanel();

        DefaultListModel dlm = new DefaultListModel();
        dlm.addElement(new Wolf(-1,-1, null));
        dlm.addElement(new Sheep(-1,-1, null));
        dlm.addElement(new Fox(-1,-1, null));

        JList list = new JList(dlm);
        list.setCellRenderer(new ListEntryCellRenderer());

        dialogPanel.add(BorderLayout.CENTER, new JScrollPane(list));
        dialogPanel.add(BorderLayout.SOUTH, new JButton("button"));

        JDialog dialogWindow = new JDialog();

        dialogWindow.setLocationRelativeTo(mainFrame);
        dialogWindow.add(dialogPanel);
        dialogWindow.setVisible(true);
        /*System.out.println(gb.getField().getX() + " " + gb.getField().getY() + " " + gb.getField().getOrganism());
        System.out.println("Strength: " + gb.getField().getOrganism().getStrength());
        System.out.println("Initiative: " + gb.getField().getOrganism().getInitiative());
        System.out.println("Hello!");*/
    }

    private static class ListEntryCellRenderer extends JLabel implements ListCellRenderer {

        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            Organism entry = (Organism) value;

            setText(entry.getName());
            setIcon(entry.getIcon());

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);

            return this;
        }
    }

    private static void drawOrganisms() {
        for (GridButton button : gridButtons) {
            Organism org = button.getField().getOrganism();
            if (org != null) {
                button.setIcon(org.getIcon());
            }
            else button.setIcon(MyConsts.NULL_SPRITE);
        }
    }

    private static void doTurn() {
        for(Organism org : world.getSortedInitiativeList()) {
            if(org.getIsAlive()) org.action();
            else world.getDeleteList().add(org);
        }

        world.getInitiativeList().addAll(world.getNewOrgList());
        world.getInitiativeList().removeAll(world.getDeleteList());
        world.getNewOrgList().clear();
        world.getDeleteList().clear();
        System.out.println(turnCounter++);
    }

    public static void startGame() {
        guiSetup();
        world.addNewOrganism(new Wolf(10,10, world));
        world.addNewOrganism(new Wolf(9,9, world));
        world.addNewOrganism(new Wolf(11,10, world));
        world.addNewOrganism(new Wolf(12,11, world));
        world.addNewOrganism(new Wolf(11,12, world));
        world.addNewOrganism(new Wolf(12,12, world));
        world.addNewOrganism(new Wolf(11,11, world));
        world.getInitiativeList().addAll(world.getNewOrgList());
        drawOrganisms();
    }
}

