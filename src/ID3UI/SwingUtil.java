
package ID3UI;

import javax.swing.*;


class SwingUtil
{
    /**
     * Invokes the given Runnable in the AWT event dispatching thread,
     * and waits for it to finish. This method may be called from any thread,
     * including the event dispatching thread itself.
     * @see SwingUtilities#invokeAndWait(java.lang.Runnable)
     * @param runnable the Runnable to be executed.
     */
    public static void invokeAndWait(Runnable runnable)
    {
        try
        {
            if (SwingUtilities.isEventDispatchThread())
            {
                runnable.run();
            }
            else
            {
                SwingUtilities.invokeAndWait(runnable);
            }
        }
        catch (Exception ex)
        {
            // Ignore any exceptions.
        }
    }


    /**
     * Invokes the given Runnable in the AWT event dispatching thread, not
     * necessarily right away. This method may be called from any thread,
     * including the event dispatching thread itself.
     * @see SwingUtilities#invokeLater(java.lang.Runnable)
     * @param runnable the Runnable to be executed.
     */
    public static void invokeLater(Runnable runnable)
    {
        if (SwingUtilities.isEventDispatchThread())
        {
            runnable.run();
        }
        else
        {
            SwingUtilities.invokeLater(runnable);
        }
    }
}
