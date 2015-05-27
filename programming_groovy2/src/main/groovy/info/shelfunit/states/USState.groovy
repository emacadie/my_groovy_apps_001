package info.shelfunit.states

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable 
import groovy.transform.ToString

@Immutable
@ToString( includeNames = true )
@EqualsAndHashCode
class USState {
    String name
    String abbrev
    String capital
    int yearJoined
}

