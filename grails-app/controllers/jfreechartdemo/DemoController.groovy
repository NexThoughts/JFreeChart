package jfreechartdemo

import grails.util.GrailsUtil
import grails.web.context.ServletContextHolder
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartRenderingInfo
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.axis.NumberAxis
import org.jfree.chart.encoders.EncoderUtil
import org.jfree.chart.entity.StandardEntityCollection
import org.jfree.chart.plot.PiePlot
import org.jfree.chart.plot.PlotOrientation
import org.jfree.chart.plot.XYPlot
import org.jfree.chart.renderer.xy.XYItemRenderer
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.data.general.DefaultPieDataset
import org.jfree.data.general.SeriesException
import org.jfree.data.time.Second
import org.jfree.data.time.TimeSeries
import org.jfree.data.time.TimeSeriesCollection
import org.jfree.data.xy.DefaultXYZDataset
import org.jfree.data.xy.XYDataset
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection

import java.awt.Color

class DemoController {

    def index() {
    }

    String path() {
        String path = ''
        path = ServletContextHolder.getServletContext().getRealPath("/")
        return path
    }

    def pieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset()
        dataset.setValue("IPhone 5s", 20)
        dataset.setValue("SamSung Grand", 20)
        dataset.setValue("MotoG", 40)
        dataset.setValue("Nokia Lumia", 10)

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Mobile Sales",   // chart title
                dataset,          // data
                true,             // include legend
                false,               //include tooltips
                false)

        int width = 700   /* Width of the image */
        int height = 500  /* Height of the image */
        File pieChart = new File("${path()}/PieChart")
        ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height)
        render file: pieChart, contentType: "image/png"

    }

    def barChart() {
        String fiat = "FIAT"
        String audi = "AUDI"
        String ford = "FORD"
        String speed = "Speed"
        String millage = "Millage"
        String userrating = "User Rating"
        String safety = "safety"

        DefaultCategoryDataset dataset = new DefaultCategoryDataset()

        dataset.addValue(1.0, fiat, speed)    //value, rowkey, column key
        dataset.addValue(3.0, fiat, userrating)
        dataset.addValue(5.0, fiat, millage)
        dataset.addValue(5.0, fiat, safety)

        dataset.addValue(5.0, audi, speed)
        dataset.addValue(6.0, audi, userrating)
        dataset.addValue(10.0, audi, millage)
        dataset.addValue(4.0, audi, safety)

        dataset.addValue(4.0, ford, speed)
        dataset.addValue(2.0, ford, userrating)
        dataset.addValue(3.0, ford, millage)
        dataset.addValue(6.0, ford, safety)

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "CAR USAGE STATISTICS",
                "Category", "Score",
                dataset, PlotOrientation.VERTICAL,
                true, true, false)

        int width = 640 /* Width of the image */
        int height = 480 /* Height of the image */
        File barChartFile = new File("${path()}/BarChart")
        ChartUtilities.saveChartAsJPEG(barChartFile, barChart, width, height)
        render file: barChartFile, contentType: "image/png"

    }

    def lineChart() {
        DefaultCategoryDataset lineChartDataSet = new DefaultCategoryDataset()
        lineChartDataSet.addValue(15, "schools", "1970")  //value, rowkey, column key
        lineChartDataSet.addValue(30, "schools", "1980")
        lineChartDataSet.addValue(30, "schools", "1980")
        lineChartDataSet.addValue(60, "schools", "1990")
        lineChartDataSet.addValue(120, "schools", "2000")
        lineChartDataSet.addValue(240, "schools", "2010")
        lineChartDataSet.addValue(300, "schools", "2014")



        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Schools Vs Years", "Year",
                "Schools Count",
                lineChartDataSet, PlotOrientation.HORIZONTAL,
                true, true, false)

        int width = 640 /* Width of the image */
        int height = 480 /* Height of the image */
        File lineChart = new File("${path()}/LineChart")
        ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height)
        render file: lineChart, contentType: "image/png"

    }

    def xyChart() {

        XYSeries firefox = new XYSeries("Firefox")
        firefox.add(1.0, 1.0) //cordinates
        firefox.add(2.0, 4.0)
        firefox.add(3.0, 3.0)
        XYSeries chrome = new XYSeries("Chrome")
        chrome.add(1.0, 4.0)
        chrome.add(2.0, 5.0)
        chrome.add(3.0, 6.0)
        XYSeries iexplorer = new XYSeries("InternetExplorer")
        iexplorer.add(3.0, 4.0)
        iexplorer.add(4.0, 5.0)
        iexplorer.add(5.0, 4.0)
        XYSeries aa = new XYSeries("AAA")
        aa.add(1, 2)
        aa.add(4, 5)
        aa.add(6, 7)
        XYSeriesCollection dataset = new XYSeriesCollection()
        dataset.addSeries(firefox)
        dataset.addSeries(chrome)
        dataset.addSeries(iexplorer)
        dataset.addSeries(aa)

        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Browser usage statastics",
                "Category",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false)


        int width = 640 /* Width of the image */
        int height = 480 /* Height of the image */
        File xyChart = new File("${path()}/XYLineChart")
        ChartUtilities.saveChartAsJPEG(xyChart, xylineChart, width, height)
        render file: xyChart, contentType: "image/png"

    }

    def barChart3D() {
        String fait = "FAIT"
        String audi = "AUDI"
        String ford = "FORD"
        String speed = "Speed"
        String popular = "Popular"
        String mailage = "Mailage"
        String userrating = "User Rating"
        String safty = "safty"
        DefaultCategoryDataset dataset = new DefaultCategoryDataset()

        dataset.addValue(1.0, fait, speed)
        dataset.addValue(4.0, fait, popular)
        dataset.addValue(3.0, fait, userrating)
        dataset.addValue(5.0, fait, mailage)
        dataset.addValue(5.0, fait, safty)

        dataset.addValue(5.0, audi, speed)
        dataset.addValue(7.0, audi, popular)
        dataset.addValue(6.0, audi, userrating)
        dataset.addValue(10.0, audi, mailage)
        dataset.addValue(4.0, audi, safty)

        dataset.addValue(4.0, ford, speed)
        dataset.addValue(3.0, ford, popular)
        dataset.addValue(2.0, ford, userrating)
        dataset.addValue(3.0, ford, mailage)
        dataset.addValue(6.0, ford, safty)

//        dataset.setValue(8.0, ford, safty)     //To update existing value
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Car Usage Statistics",
                "Category",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false)

        int width = 640 /* Width of the image */
        int height = 480 /* Height of the image */
        File barChart3D = new File("${path()}/barChart3D")
        ChartUtilities.saveChartAsJPEG(barChart3D, barChart, width, height)
        render file: barChart3D, contentType: "image/png"

    }


    def pieChartWithCustomColor() {
        DefaultPieDataset dataset = new DefaultPieDataset()
        dataset.setValue("IPhone 5s", 20)
        dataset.setValue("SamSung Grand", 20)
        dataset.setValue("MotoG", 40)
        dataset.setValue("Nokia Lumia", 10)

        JFreeChart chart = ChartFactory.createPieChart(
                "Mobile Sales",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false)

        PiePlot plot = chart.getPlot()
        plot.setStartAngle(10)
        plot.setSectionPaint("IPhone 5s", Color.black)
        plot.setSectionPaint("MotoG", Color.red)
        plot.setSectionPaint("Nokia Lumia", new Color(128, 128, 128)) //grey color code
        int width = 640   /* Width of the image */
        int height = 480  /* Height of the image */
        File pieChart = new File("${path()}/CustomPieChart")
        ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height)
        render file: pieChart, contentType: "image/png"

    }
}
