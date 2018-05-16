package common;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import authoring.GUI;

/**
 * Simple dummy thread to create the GUI and run it
 *
 * @author Dilshad Khatri, Alvis Koshy, Drew Noel, Jonathan Tung
 * @version 1.0
 * @since 2017-03-02
 */
public class MainThread implements Runnable {

	@Override
	public void run() {
		GUI frame = new GUI();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowListener()
				{

					@Override
					public void windowActivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
						
						File functionCounter = new File(frame.functionCounter.toString());
						BufferedWriter wr = null;
						try {
							functionCounter.createNewFile();
							wr = new BufferedWriter(new FileWriter(functionCounter));
							wr.write(frame.counterMap.toString());
							wr.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.err.println("File creation failed, please contact an administrator.");
						}
						
						
						if (!frame.getLeftPanel().getList().isEmpty())
						{
							int choice = JOptionPane.showConfirmDialog(frame, "Unsaved changes will be discarded." + System.lineSeparator()+"Exit?", "Discard changes?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
							if (choice == JOptionPane.OK_OPTION)
							{
								System.exit(0);
								
							}
							
							
						}
						else
						{
							System.exit(0);
						}
						
						
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowOpened(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			
				});
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
