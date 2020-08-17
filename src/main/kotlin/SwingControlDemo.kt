import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import kotlin.system.exitProcess

class SwingControlDemo {
    private lateinit var mainFrame: JFrame
    private lateinit var headerLabel: JLabel
    private lateinit var statusLabel: JLabel
    private lateinit var controlPanel: JPanel
    private fun prepareGUI() {
        mainFrame = JFrame("Kotlin SWING Examples")
        mainFrame.setSize(400, 400)
        mainFrame.layout = GridLayout(3, 1)
        headerLabel = JLabel("", JLabel.CENTER)
        statusLabel = JLabel("", JLabel.CENTER)
        statusLabel.setSize(350, 100)
        mainFrame.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(windowEvent: WindowEvent) {
                exitProcess(0)
            }
        })
        controlPanel = JPanel()
        controlPanel.layout = FlowLayout()
        mainFrame.add(headerLabel)
        mainFrame.add(controlPanel)
        mainFrame.add(statusLabel)
        mainFrame.isVisible = true
    }

    private fun showEventDemo() {
        headerLabel.text = "Control in action: Button"
        val okButton = JButton("OK")
        val submitButton = JButton("Submit")
        val cancelButton = JButton("Cancel")
        okButton.actionCommand = "OK"
        submitButton.actionCommand = "Submit"
        cancelButton.actionCommand = "Cancel"
        okButton.addActionListener(ButtonClickListener())
        submitButton.addActionListener(ButtonClickListener())
        cancelButton.addActionListener(ButtonClickListener())
        controlPanel.add(okButton)
        controlPanel.add(submitButton)
        controlPanel.add(cancelButton)
        mainFrame.isVisible = true
    }

    private inner class ButtonClickListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            when (e.actionCommand) {
                "OK" -> statusLabel.text = "Ok Button clicked."
                "Submit" -> statusLabel.text = "Submit Button clicked."
                else -> statusLabel.text = "Cancel Button clicked."
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val swingControlDemo = SwingControlDemo()
            swingControlDemo.showEventDemo()
        }
    }

    init {
        prepareGUI()
    }
}