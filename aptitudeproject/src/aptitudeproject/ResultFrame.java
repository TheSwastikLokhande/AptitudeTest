package aptitudeproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;

class ResultFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel respan;
	MainPanel imgpan;
	JPanel stspan;
	JPanel bpan;

	JLabel res;
	Image img;
	JLabel lmrk;
	JLabel lsub;
	JButton ok,re;
	

	
	ResultFrame(String ttl)
	{
		super(ttl);

		setLayout(new GridLayout(4,1));

		respan=new JPanel();

		res=new JLabel("Your Result ");
		res.setFont(new Font("",Font.BOLD,25));
		respan.add(res);
		add(respan);

		try
		{
			img=ImageIO.read(new File("C:\\Users\\Swastik\\eclipse-workspace\\aptitudeproject.zip_expanded\\aptitudeproject\\img\\WATING.gif"));
			imgpan=new MainPanel(img);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		add(imgpan);

		stspan=new JPanel();
		lmrk=new JLabel("Mark ");
		lmrk.setFont(new Font("",Font.BOLD,25));
		stspan.add(lmrk);
		add(stspan);

		bpan=new JPanel();

		ok=new JButton("Okay");
		ok.setFont(new Font("",Font.BOLD,25));
		ok.addActionListener(this);
		bpan.add(ok);

		re=new JButton("Get Result");
		re.setFont(new Font("",Font.BOLD,25));
		re.addActionListener(this);
		bpan.add(re);

		add(bpan);

		setVisible(true);
		setLocation(0,0);
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==re)
		{
			res.setText("Your Score IS "+MainWindow.getMark());
			lmrk.setText("Mark "+MainWindow.getMark()+" Out Of 20 "+" Subject "+SubjectChooser.getSubject());

			if(MainWindow.getMark()>=5) 
			{
				
				try
				{
					imgpan.setImage(ImageIO.read(new File("C:\\Users\\Swastik\\eclipse-workspace\\aptitudeproject.zip_expanded\\aptitudeproject\\img\\PASS.bmp")));	
				}
				catch (Exception ae)
				{
					ae.printStackTrace();
				}
			}
			else
			{				
				try
				{
					imgpan.setImage(ImageIO.read(new File("C:\\Users\\Swastik\\eclipse-workspace\\aptitudeproject.zip_expanded\\aptitudeproject\\img\\FAIL.bmp")));	
				}
				catch (Exception ae)
				{
					ae.printStackTrace();
				}
			}
		}
	
	}
	public static void main(String []args) {
		new ResultFrame("Aptitude Test Result");
	}

}
