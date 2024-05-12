package vibro_anal


//fun main() {
//
//}
import org.apache.commons.math3.complex.Complex
import org.apache.commons.math3.transform.DftNormalization
import org.apache.commons.math3.transform.FastFourierTransformer
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import javax.swing.JFrame
import javax.swing.SwingUtilities
import kotlin.math.PI
import kotlin.math.sin


class VibrationSpectrumChart(frequency: DoubleArray, amplitude: DoubleArray) : JFrame("Vibration Spectrum Chart") {
    init {

        // Create dataset
        val series = XYSeries("Vibration Spectrum")
        for (i in frequency.indices) {
            series.add(frequency[i], amplitude[i])
        }
        val dataset = XYSeriesCollection(series)



        // Create chart
//        val chart: JFreeChart = ChartFactory.createXYLineChart(
//            title = "Vibration Spectrum",  // Chart title
//            xAxisLabel = "Frequency (Hz)",  // X-axis label
//            yAxisLabel = "Amplitude",  // Y-axis label
//            dataset = dataset,
//            orientation = PlotOrientation.HORIZONTAL,
//            legend = false,
//            tooltips = false,
//            urls = false
//        )
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
            // Example spectrum data (replace with your actual data)
            val frequency = doubleArrayOf(10.0, 20.0, 30.0, 40.0, 50.0)
            val amplitude = doubleArrayOf(1.2, 2.3, 1.5, 3.0, 2.1)

            // Create and display chart
            SwingUtilities.invokeLater {
                val chart = VibrationSpectrumChart(frequency, amplitude)
                chart.setSize(800, 600)
                chart.setLocationRelativeTo(null)
                chart.setDefaultCloseOperation(EXIT_ON_CLOSE)
                chart.isVisible = true
            }
        }
    }
}


object VibrationSpectrumCalculator2 {
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) {

        // Parameters
        val sampleRate = 1000.0 // Sample rate in Hz
        val duration = 1.0 // Duration of the signal in seconds
        val freq1 = 50.0 // Frequency of the first sine wave in Hz
        val freq2 = 150.0 // Frequency of the second sine wave in Hz

        // Calculate the number of samples
        val numSamples = (duration * sampleRate).toInt()

        // Generate time array
        val time = DoubleArray(numSamples) { it.toDouble() / sampleRate }

        // Generate signal array with two superimposed frequencies
        val signal = DoubleArray(numSamples) {
            (sin(2 * PI * freq1 * time[it]) + sin(2 * PI * freq2 * time[it])) // 100.0
        }

        // Print the generated signal array
        println("Generated signal array (with size ${signal.size}): ")
        println(signal.joinToString(", "))

        // Example XYZ acceleration data (replace with your actual data)
        val dataX = signal//doubleArrayOf()

        // Sample rate and other parameters
        //val sampleRate = 1000.0 // Sample rate in Hz (replace with your actual sample rate)
        val windowSize = 1024 // FFT window size (adjust as needed)

        // Calculate magnitude spectra for each dimension
        val magnitudeSpectrumX = calculateMagnitudeSpectrum(dataX, sampleRate, windowSize)

        // Combine spectra (for example, by averaging)
        val combinedSpectrum = magnitudeSpectrumX//combineSpectra(magnitudeSpectrumX)

        // Determine frequency bins
        val frequencyBins = calculateFrequencyBins(sampleRate, windowSize)

        // Plot the spectrum using the frequency and amplitude data
        plotSpectrum(frequencyBins, combinedSpectrum)
    }

    fun calculateMagnitudeSpectrum(data: DoubleArray?, sampleRate: Double, windowSize: Int): DoubleArray {
        // Perform FFT
        val transformer = FastFourierTransformer(DftNormalization.UNITARY)
        val transformed: Array<Complex> =
            transformer.transform(data, org.apache.commons.math3.transform.TransformType.FORWARD)
        println("transformed: ${transformed.joinToString()}")
        // Calculate magnitude spectrum
        val magnitudeSpectrum = DoubleArray(windowSize / 2 + 1)
        for (i in magnitudeSpectrum.indices) {
            magnitudeSpectrum[i] = transformed[i].abs()
        }
        return magnitudeSpectrum
    }
    fun calculateFrequencyBins(sampleRate: Double, windowSize: Int): DoubleArray {
        // Calculate frequency bins
        val frequencyBins = DoubleArray(windowSize / 2 + 1)
        for (i in frequencyBins.indices) {
            frequencyBins[i] = i * sampleRate / windowSize
        }
        return frequencyBins
    }

    fun plotSpectrum(frequency: DoubleArray?, amplitude: DoubleArray?) {
        // Plot the spectrum using a charting library (e.g., JFreeChart)
        // Your code to create and display the chart goes here
    }
}

