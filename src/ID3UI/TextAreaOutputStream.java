
package ID3UI;

import java.io.*;

import javax.swing.*;



class TextAreaOutputStream extends FilterOutputStream implements Runnable
{
    private JTextArea textArea;


    public TextAreaOutputStream(JTextArea textArea)
    {
        super(new ByteArrayOutputStream());

        this.textArea = textArea;
    }


    // Implementation for FilterOutputStream.

    public void flush() throws IOException
    {
        super.flush();

        SwingUtil.invokeAndWait(this);
    }


    // Implementation for Runnable.

    public synchronized void run()
    {
        ByteArrayOutputStream out = (ByteArrayOutputStream)super.out;

        // Has any new text been written?
        String text = out.toString();
        if (text.length() > 0)
        {
            // Append the accumulated text to the text area.
            textArea.append(text);

            // Clear the buffer.
            out.reset();
        }
    }
}
