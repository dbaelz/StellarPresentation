package de.dbaelz.stellar.demo.kkon2021

import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingUtilities

object HelloWorldSwing {
    private fun helloWorldSwing() {
        JFrame("Hello World Swing").apply {
            preferredSize = Dimension(640, 480)

            contentPane.add(JLabel("Hello World"))

            pack()
            isVisible = true
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater { helloWorldSwing() }
    }
}