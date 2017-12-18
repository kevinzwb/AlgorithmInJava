//package logging;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//import java.util.logging.*;
//import javax.swing.*;
//
//public class LoggingImageViewer {
//
//    public static void main(String[] agrs)
//    {
//        if (System.getProperty("java.util.logging.congif.class") == null
//                && System.getProperty("java.logging.config.ile") == null)
//        {
//            try
//            {
//                Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
//                final int Log_Rotation_Count = 10;
//                Handler handler = new FileHandler ("%h/LoggingImageViewer.log",0,Log_Rotation_Count);
//                Logger.getLogger("com.horstmann.corejava").addHandler(handler);
//            }
//            catch (IOException e)
//            {
//                Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "can't create log file hanlder",e);
//            }
//        }
//
//        EventQueue.invokeLater(() ->
//        {
//            Handler windowHandler = new WindowHandler();
//            windowHandler.setLevel((Level.ALL));
//            Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);
//
//
//            JFrame frame = new ImageViewerFrame();
//            frame.setTitle("LoggingIamgeViewer");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            Logger.getLogger("com.horstmann.core.java").fine("Showing frame");
//            frame.setVisible(true);
//        });
//    }
//}
//
//
//class ImageViewerFrame extends JFrame{
//    private static final int DEFAULT_WIDTH = 300;
//    private static final int DEFAULT_HIGHT = 400;
//
//    private JLabel label;
//    private static Logger logger = Logger.getLogger("com.horstmann.corejava");
//
//    public ImageViewerFrame()
//    {
//        logger.entering("ImageViewerFrame","<init>");
//        setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
//
//        //set up menu bar
//        JMenuBar menuBar = new JMenuBar();
//        setJMenuBar(menuBar);
//
//        JMenu menu = new JMenu("File");
//        menuBar.add(menu);
//
//        JMenuItem openItem = new JMenuItem("Open");
//        menu.add(openItem);
//        openItem.addActionListener(new FileOpenListener());
//
//        JMenuItem exitItem = new JMenuItem("Exit");
//        menu.add(exitItem);
//        exitItem.addActionListener(new ActionListener()
//        {
//            public void actionPeformed(ActionEvent event)
//            {
//                logger.fine("Exiting.");
//                System.exit(0);
//            }
//        });
//
//        // use a label to dispaly the images
//        label = new JLabel();
//        add(label);
//        logger.exiting("ImageViewerFrame","<init>");
//    }
//
//    private class FileOpenListener implements ActionListener
//    {
//        @Override
//        public void actionPerformed(ActionEvent event)
//        {
//         logger.entering("ImageViewerFrame.FileOpenListener","actionPerformed",event);
//
//         //set up file chooser
//         JFileChooser chooser = new JFileChooser();
//         chooser.setCurrentDirectory(new File("."));
//
//         // accept all files ending with .gif
//         chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
//         {
//             public boolean accept(File f)
//             {
//                 if (f.getName().toLowerCase().endsWith(".gif")) return true;
//                 if (f.isDirectory()) return true;
//                 return false;
//             }
//
//             public String getDescription()
//             {
//                 return "GIF Images";
//             }
//         });
//
//
//         int r = chooser.showOpenDialog(ImageViewerFrame.this);
//
//         if(r == JFileChooser.APPROVE_OPTION)
//         {
//             String name = chooser.getSelectedFile().getPath();
//             logger.log(Level.FINE,"reading file {0}",name);
//             label.setIcon(new ImageIcon(name));
//         }
//
//         else logger.fine("Fine open dialog canceled.");
//         logger.exiting("ImageViewerFrame.FileOpenListener","actionPerformed");
//        }
//    }
//}
//
//
//
//class WindowHandler extends StreamHandler
//{
//    private JFrame frame;
//
//    public WindowHandler()
//    {
//        frame = new JFrame();
//        final JTextArea output = new JTextArea();
//        output.setEditable(false);
//        frame.setSize(200,200);
//        frame.add(new JScrollPane(output));
//        frame.setFocusableWindowState(false);
//        frame.setVisible(true);
//
//        setOutputStream(new OutputStream()
//        {
//            public void write(int b)
//            {
//
//            }
//
//            public void write(byte[] b, int off, int len)
//            {
//                output.append(new String(b, off ,len));
//            }
//        });
//    }
//
//    public void publish(LogRecord record)
//    {
//        if(!frame.isVisible()) return;
//        super.publish(record);
//        flush();
//    }
//
//}