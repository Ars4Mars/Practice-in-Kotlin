package vibro_anal

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import org.jtransforms.fft.DoubleFFT_1D
import javax.swing.JFrame
import javax.swing.SwingUtilities
import kotlin.math.sin
//import org.knowm.xchart.SwingWrapper
//import org.knowm.xchart.XYChart
//import org.knowm.xchart.XYChartBuilder
import kotlin.math.sqrt

class VibrationSpectrumChart2(frequency: DoubleArray, amplitude: DoubleArray) : JFrame("Vibration Spectrum Chart") {
    init {
        // Create dataset
        val series = XYSeries("Vibration Spectrum")
        for (i in frequency.indices) {
            series.add(frequency[i], amplitude[i])
        }
        val dataset = XYSeriesCollection(series)

        val chart: JFreeChart = ChartFactory.createXYLineChart(
            "Vibration Spectrum",
            "Frequency (Hz)",
            "Amplitude",
            dataset,
            PlotOrientation.VERTICAL,
            false,
            false,
            false
        )
        // Display chart in a panel
        val chartPanel = ChartPanel(chart)
        contentPane = chartPanel
    }



    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val duration   = 10.0 // Duration of acceleration data in seconds
            val sampleRate = 50.0 // Sampling rate in samples per second 2.5

            val frequency1 = 1.0   // First imposed frequency in Hz
            val frequency2 = 4.0  // Second imposed frequency in Hz
            val frequency3 = 10.0  // Three imposed frequency in Hz
            val frequency4 = 20.0  // Four imposed frequency in Hz
//            val duration   = 100.0 // Duration of acceleration data in seconds
//            val sampleRate = 500.0 // Sampling rate in samples per second 2.5
//
//            val frequency1 = 1.0   // First imposed frequency in Hz
//            val frequency2 = 30.0  // Second imposed frequency in Hz
//            val frequency3 = 40.0  // Three imposed frequency in Hz
//            val frequency4 = 200.0  // Four imposed frequency in Hz

            // Generate time array
            val numSamples = (duration * sampleRate).toInt()
            val time = DoubleArray(numSamples)
            for (i in 0 until numSamples) {
                time[i] = i / sampleRate
            }

            println("size: ${numSamples}")

            // Generate acceleration data
            val acceleration = DoubleArray(numSamples)
            for (i in 0 until numSamples) {
                acceleration[i] =
                          sin(2 * Math.PI * frequency1 * time[i]) +
                          sin(2 * Math.PI * frequency2 * time[i]) +
                          sin(2 * Math.PI * frequency3 * time[i]) +
                          sin(2 * Math.PI * frequency4 * time[i])
            }

            // Print the first few acceleration values for verification
            for (i in 0..9) {
                println("Acceleration at time " + time[i] + " seconds: " + acceleration[i])
            }

            // Example acceleration data (replace with your actual data)
            //val acceleration = doubleArrayOf()
            //val sampleRate = 100.0 // Sample rate in Hz (replace with your actual sample rate)

            // Perform FFT on acceleration data
            val magnitudeSpectrum = calculateMagnitudeSpectrum(acceleration)

            // Determine frequency bins
            val frequencyBins = calculateFrequencyBins(sampleRate, acceleration.size)

            // Plot the spectrum
            println("${frequencyBins.size}, ${magnitudeSpectrum.size}")
            println("Max Freq: ${frequencyBins.maxOrNull()}")

            // Create and display chart
            SwingUtilities.invokeLater {
                val chart = VibrationSpectrumChart2(frequencyBins, magnitudeSpectrum)
                chart.setSize(800, 600)
                chart.setLocationRelativeTo(null)
                chart.setDefaultCloseOperation(EXIT_ON_CLOSE)
                chart.isVisible = true
            }
        }

        fun calculateMagnitudeSpectrum(data: DoubleArray): DoubleArray {
            // Perform FFT
            val fft = DoubleFFT_1D(data.size.toLong())
            fft.realForward(data)

            // Calculate magnitude spectrum
            val magnitudeSpectrum = DoubleArray(data.size / 2 + 1)
            try {
                for (i in magnitudeSpectrum.indices-1) {
                    magnitudeSpectrum[i] = sqrt(data[2 * i] * data[2 * i] + data[2 * i + 1] * data[2 * i + 1])
                }
            }catch (e: Exception) {}

            return magnitudeSpectrum
        }

        fun calculateFrequencyBins(sampleRate: Double, dataSize: Int): DoubleArray {
            // Calculate frequency bins
            val frequencyBins = DoubleArray(dataSize / 2 + 1)
            val deltaF = sampleRate / dataSize
            for (i in frequencyBins.indices) {
                frequencyBins[i] = i * deltaF
            }
            return frequencyBins
        }
    }
}

