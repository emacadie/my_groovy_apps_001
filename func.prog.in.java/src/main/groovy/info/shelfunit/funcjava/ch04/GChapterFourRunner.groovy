package info.shelfunit.funcjava.ch04;

import java.awt.Color;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class GChapterFourRunner {
    static final String className = "GChapterFourRunner.";
    private String methodName;
    /*
    public int totalAssetValues( final List< Asset > assets ) {
        return assets.stream()
            .mapToInt( Asset::getValue )
            .sum();
    }

    public int totalBondValues( final List< Asset > assets ) {
        return assets.stream()
            .mapToInt( asset -> asset.getType() == Asset.AssetType.BOND ? asset.getValue() : 0 )
            .sum();
    }

    public int totalStockValues( final List< Asset > assets ) {
        return assets.stream()
            .mapToInt( asset -> asset.getType() == Asset.AssetType.STOCK ? asset.getValue() : 0 )
            .sum();
    }

    public int totalAssetValuesWithSelector( final List< Asset > assets, final Predicate< Asset > selector ) {
        return assets.stream()
            .filter( selector )
            .mapToInt( Asset::getValue )
            .sum();
    }
    */
    final List< Asset > assets = Arrays.asList(
        new Asset( Asset.AssetType.BOND, 1000 ),
        new Asset( Asset.AssetType.BOND, 2000 ),
        new Asset( Asset.AssetType.STOCK, 3000 ),
        new Asset( Asset.AssetType.STOCK, 4000 )
    );
    
    public void separateConcerns() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        /*
        System.out.println( "Total of assets using stream: " + this.totalAssetValues( assets ) );
        System.out.println( "Total of bond assets using stream: " + this.totalBondValues( assets ) );
        System.out.println( "Total of stock assets using stream: " + this.totalStockValues( assets ) );
        System.out.println( "Total of assets using stream and predicate: " + this.totalAssetValuesWithSelector( assets, asset -> true ) );
        System.out.println( "Total of bond assets using stream and predicate: " +
            this.totalAssetValuesWithSelector( assets, asset -> asset.getType() == Asset.AssetType.BOND ) );
        System.out.println( "Total of stock assets using stream and predicate: " +
            this.totalAssetValuesWithSelector( assets, asset -> asset.getType() == Asset.AssetType.STOCK ) );
        */
    } // separateConcerns()

    public void delegateUsingLambdas() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        /*
        NAVCalculator nCalc = new NAVCalculator( ticker -> new BigDecimal( "6.01" ) );
        System.out.println( "Value of 1000 shares: " + nCalc.computeStockWorth( "GOOG", 1000 ) );
        NAVCalculator yCalc = new NAVCalculator( YahooFinance::getPrice );
        System.out.println( "100 shares of VZ are worth: " + yCalc.computeStockWorth( "VZ", 100 ) );
        System.out.println( "Let's do that again without a method reference, slightly more verbose" );
        Function< String, BigDecimal > yFinance = ticker -> { return YahooFinance.getPrice( ticker ); };
        NAVCalculator yCalcB = new NAVCalculator( yFinance );
        System.out.println( "100 shares of VZ are worth: " + yCalcB.computeStockWorth( "VZ", 100 ) );
        System.out.println( "What about an invalid stock? Like VNKT" );
        System.out.println( "100 shares of VNKT are worth: " + yCalcB.computeStockWorth( "VNKT", 100 ) );
        */
    } // delegateUsingLambdas()

    @SuppressWarnings( "unchecked" )
    public void decorateUsingLambdas() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        /*
        final Camera camera = new Camera();
        final Consumer< String > printCaptured = ( filterInfo ) ->
        System.out.println( String.format( "with %s: %s", filterInfo,
                            camera.capture( new Color( 200, 100, 200 ) ) ) );
        printCaptured.accept( "no filter" );
        camera.setFilters( Color::brighter );
        printCaptured.accept( "brighter filter" );
        camera.setFilters( Color::darker );
        printCaptured.accept( "darker filter" );

        camera.setFilters( Color::brighter, Color::darker );
        printCaptured.accept( "combining filters" );

        camera.setFilters( Color::darker, Color::darker );
        printCaptured.accept( "two darks" );
        */
    } // decorateUsingLambdas()
    
    public void useDefaultMethods() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        /*
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
        */
    } // useDefaultMethods

    public void createFluentInterfaces() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        /*
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
        System.out.println( "Now, for a FluentMailer with a block" );
        FluentMailer.send( mailer ->
            mailer.from( "build@funcjava.com" )
                  .to( "author@funcjava.com" )
                  .subject( "Important message" )
                  .body( "Venkat rocks" )
        );
        System.out.println( "So Consumer in Java is like Closure in Groovy, I think" );
       */
    } // createFluentInterfaces

    public void dealWithExceptions() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "We will take a closer look at this in chapter 5" );
        /*
        Stream.of( "/usr", "/tmp" )
            .map( path -> new File( path ).getCanonicalPath() )
            .forEach( f -> System.out.print( f + ", " ) );
        */
    } // dealWithExceptions

    static void main( String... args ) {
        GChapterFourRunner cFourR = new GChapterFourRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "separateConcerns" :
                cFourR.separateConcerns();
                break;
            case "delegateUsingLambdas":
                cFourR.delegateUsingLambdas();
                break;
            case "decorateUsingLambdas":
                cFourR.decorateUsingLambdas();
                break;
            case "useDefaultMethods":
                cFourR.useDefaultMethods();
                break;
            case "createFluentInterfaces":
                cFourR.createFluentInterfaces();
                break;
            case "dealWithExceptions":
                cFourR.dealWithExceptions();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
} // line 168


        
