package vibro_anal

import org.apache.commons.math3.complex.Complex
import org.apache.commons.math3.transform.DftNormalization
import org.apache.commons.math3.transform.FastFourierTransformer
import kotlin.math.min


//fun main() {
//
//}



object VibrationSpectrumCalculator {
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) {
        // Example XYZ acceleration data (replace with your actual data)
        val dataX = doubleArrayOf()
        val dataY = doubleArrayOf()
        val dataZ = doubleArrayOf()

        // Sample rate and other parameters
        val sampleRate = 100.0 // Sample rate in Hz (replace with your actual sample rate)
        val windowSize = 1024 // FFT window size (adjust as needed)

        // Calculate magnitude spectra for each dimension
        val magnitudeSpectrumX = calculateMagnitudeSpectrum(dataX, sampleRate, windowSize)
        val magnitudeSpectrumY = calculateMagnitudeSpectrum(dataY, sampleRate, windowSize)
        val magnitudeSpectrumZ = calculateMagnitudeSpectrum(dataZ, sampleRate, windowSize)

        // Combine spectra (for example, by averaging)
        val combinedSpectrum = combineSpectra(magnitudeSpectrumX, magnitudeSpectrumY, magnitudeSpectrumZ)

        // Determine frequency bins
        val frequencyBins = calculateFrequencyBins(sampleRate, windowSize)

        // Plot the spectrum using the frequency and amplitude data
        plotSpectrum(frequencyBins, combinedSpectrum)
    }

    fun calculateMagnitudeSpectrum(data: DoubleArray?, sampleRate: Double, windowSize: Int): DoubleArray {
        // Perform FFT
        val transformer = FastFourierTransformer(DftNormalization.STANDARD)
        val transformed: Array<Complex> =
            transformer.transform(data, org.apache.commons.math3.transform.TransformType.FORWARD)

        // Calculate magnitude spectrum
        val magnitudeSpectrum = DoubleArray(windowSize / 2 + 1)
        for (i in magnitudeSpectrum.indices) {
            magnitudeSpectrum[i] = transformed[i].abs()
        }
        return magnitudeSpectrum
    }

    fun combineSpectra(spectrumX: DoubleArray, spectrumY: DoubleArray, spectrumZ: DoubleArray): DoubleArray {
        // Combine spectra (for example, by averaging)
        val numBins: Int = min(spectrumX.size, min(spectrumY.size, spectrumZ.size))
        val combinedSpectrum = DoubleArray(numBins)
        for (i in 0 until numBins) {
            combinedSpectrum[i] = (spectrumX[i] + spectrumY[i] + spectrumZ[i]) / 3.0
        }
        return combinedSpectrum
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

