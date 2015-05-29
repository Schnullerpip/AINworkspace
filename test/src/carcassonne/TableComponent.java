package carcassonne;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;

public class TableComponent extends JComponent{
	
	public TableComponent(Game game){
		setLayout(new GridLayout(0, game.getTable().getLengthX()));
		setPreferredSize(new Dimension(TileComponent.SIZEX*columns, TileComponent.SIZEY*rows));
		
		for(int columns = 0;columns < game.getTable().getLengthX(); columns++){
			for(int rows = 0; rows < game.getTable().getLengthY(); rows++){
				add(new TileComponent(game, columns,rows));
			}
		}		
	}
	
}
