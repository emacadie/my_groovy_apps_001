package info.shelfunit.funcjava.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChapterFourRunner {
    private static final String className = "ChapterFourRunner.";
    private String methodName;

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

    final List< Asset > assets = Arrays.asList(
        new Asset( Asset.AssetType.BOND, 1000 ),
        new Asset( Asset.AssetType.BOND, 2000 ),
        new Asset( Asset.AssetType.STOCK, 3000 ),
        new Asset( Asset.AssetType.STOCK, 4000 )
    );
    
    public void separateConcerns() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "Total of assets using stream: " + this.totalAssetValues( assets ) );
        System.out.println( "Total of bond assets using stream: " + this.totalBondValues( assets ) );
        System.out.println( "Total of stock assets using stream: " + this.totalStockValues( assets ) );
        System.out.println( "Total of assets using stream and predicate: " + this.totalAssetValuesWithSelector( assets, asset -> true ) );
        System.out.println( "Total of bond assets using stream and predicate: " +
            this.totalAssetValuesWithSelector( assets, asset -> asset.getType() == Asset.AssetType.BOND ) );
        System.out.println( "Total of stock assets using stream and predicate: " +
            this.totalAssetValuesWithSelector( assets, asset -> asset.getType() == Asset.AssetType.STOCK ) );
        
    } // separateConcerns()


    public static void main( String [] args ) {
        ChapterFourRunner cFourR = new ChapterFourRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "separateConcerns" :
                cFourR.separateConcerns();
                break;
            case "transformAList":
                // cFourR.transformAList();
                break;
            case "findElements":
                // cFourR.findElements();
                break;
            case "reuseLambda":
                // cFourR.reuseLambda();
                break;
            case "pickName":
                // cFourR.pickName( args[ 1 ] );
                break;
            case "reduceAndJoin":
                // cFourR.reduceAndJoin();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
