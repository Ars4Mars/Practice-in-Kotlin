package vibro_anal

import org.jtransforms.fft.DoubleFFT_1D
import kotlin.math.sin
//import org.knowm.xchart.SwingWrapper
//import org.knowm.xchart.XYChart
//import org.knowm.xchart.XYChartBuilder
import kotlin.math.sqrt


object AccelerationSpectrum3 {
    @JvmStatic
    fun main(args: Array<String>) {
        /////////////////////////////////////

        val duration = 10.0 // Duration of acceleration data in seconds
        val sampleRate = 100.0 // Sampling rate in samples per second
        val frequency1 = 1.0 // First imposed frequency in Hz
        val frequency2 = 2.0 // Second imposed frequency in Hz


        // Generate time array

        // Generate time array
        val numSamples = (duration * sampleRate).toInt()
        val time = DoubleArray(numSamples)
        for (i in 0 until numSamples) {
            time[i] = i / sampleRate
        }

        // Generate acceleration data

        // Generate acceleration data
        val acceleration = DoubleArray(numSamples)
        for (i in 0 until numSamples) {
            acceleration[i] = sin(2 * Math.PI * frequency1 * time[i]) + sin(2 * Math.PI * frequency2 * time[i])
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

//    fun plotSpectrum(frequency: DoubleArray?, amplitude: DoubleArray?) {
//        // Create chart
//        val chart: XYChart =
//            XYChartBuilder().width(800).height(600).title("Acceleration Spectrum").xAxisTitle("Frequency (Hz)")
//                .yAxisTitle("Amplitude").build()
//        chart.addSeries("Spectrum", frequency, amplitude)
//
//        // Display chart
//        SwingWrapper(chart).displayChart()
//    }
}

