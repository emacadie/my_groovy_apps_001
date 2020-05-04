package info.shelfunit.properties.finality

import validation.ValidLong
import validation.ConvenientFinalFieldValidator

@ConvenientFinalFieldValidator
class FinalLongHolder {
    @ValidLong( minValue = 1000L, maxValue = 1000000000L, divisorSet= [ 3L, 5L ], throwEx = true )
    def firstDefLong
    @ValidLong( minValue = 1000L, maxValue = 1000000000L, divisorSet= [ 3L, 5L ] )
    final def finalDefLong
    @ValidLong( minValue = 1000L, maxValue = 1000000000L, divisorSet= [ 3L, 5L ], throwEx = true )
    long firstRealLong
    @ValidLong( minValue = 1000L, maxValue = 1000000000L, divisorSet= [ 3L, 5L ] )
    final long finalRealLong
    
    long someOtherLong
    def anotherObject
    
}

