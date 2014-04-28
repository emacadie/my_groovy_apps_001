#!/usr/bin/env bash

##############################################################################
##
##  gorm_share start up script for UN*X
##
##############################################################################

# Add default JVM options here. You can also use JAVA_OPTS and GORM_SHARE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=""

APP_NAME="gorm_share"
APP_BASE_NAME=`basename "$0"`

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn ( ) {
    echo "$*"
}

die ( ) {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
case "`uname`" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
esac

# For Cygwin, ensure paths are in UNIX format before anything is touched.
if $cygwin ; then
    [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
fi

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`"/$link"
    fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/.." >&-
APP_HOME="`pwd -P`"
cd "$SAVED" >&-

CLASSPATH=$APP_HOME/lib/gorm_share.jar:$APP_HOME/lib/slf4j-api-1.7.7.jar:$APP_HOME/lib/mysql-connector-java-5.0.4.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/grails-datastore-gorm-hibernate4-3.0.0.RELEASE.jar:$APP_HOME/lib/grails-spring-2.3.6.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/grails-datastore-gorm-hibernate-core-3.0.0.RELEASE.jar:$APP_HOME/lib/hibernate-validator-5.0.1.Final.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/hibernate-commons-annotations-4.0.4.Final.jar:$APP_HOME/lib/hibernate-core-4.3.1.Final.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/dom4j-1.6.1.jar:$APP_HOME/lib/jcl-over-slf4j-1.7.5.jar:$APP_HOME/lib/spring-web-3.2.7.RELEASE.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/grails-bootstrap-2.3.6.jar:$APP_HOME/lib/spring-tx-3.2.7.RELEASE.jar:$APP_HOME/lib/grails-async-2.3.6.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/spring-orm-3.2.7.RELEASE.jar:$APP_HOME/lib/grails-datastore-gorm-3.0.0.RELEASE.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/grails-datastore-core-3.0.0.RELEASE.jar:$APP_HOME/lib/grails-datastore-gorm-plugin-support-3.0.0.RELEASE.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/spring-core-3.2.7.RELEASE.jar:$APP_HOME/lib/spring-jdbc-3.2.7.RELEASE.jar:$APP_HOME/lib/grails-core-2.3.6.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/jta-1.1.jar:$APP_HOME/lib/antlr-2.7.7.jar:$APP_HOME/lib/validation-api-1.1.0.Final.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/classmate-0.8.0.jar:$APP_HOME/lib/jboss-logging-annotations-1.2.0.Beta1.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/jboss-transaction-api_1.2_spec-1.0.0.Final.jar:$APP_HOME/lib/hibernate-jpa-2.1-api-1.0.0.Final.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/jandex-1.1.0.Final.jar:$APP_HOME/lib/spring-aop-3.2.7.RELEASE.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/spring-beans-3.2.7.RELEASE.jar:$APP_HOME/lib/spring-context-3.2.7.RELEASE.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/gpars-1.1.0.jar:$APP_HOME/lib/concurrentlinkedhashmap-lru-1.3.1.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/aopalliance-1.0.jar:$APP_HOME/lib/spring-expression-3.2.7.RELEASE.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/multiverse-core-0.7.0.jar:$APP_HOME/lib/jsr166y-1.7.0.jar
CLASSPATH=$CLASSPATH:$APP_HOME/lib/jboss-logging-3.1.3.GA.jar:$APP_HOME/lib/javassist-3.18.1-GA.jar

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Increase the maximum file descriptors if we can.
if [ "$cygwin" = "false" -a "$darwin" = "false" ] ; then
    MAX_FD_LIMIT=`ulimit -H -n`
    if [ $? -eq 0 ] ; then
        if [ "$MAX_FD" = "maximum" -o "$MAX_FD" = "max" ] ; then
            MAX_FD="$MAX_FD_LIMIT"
        fi
        ulimit -n $MAX_FD
        if [ $? -ne 0 ] ; then
            warn "Could not set maximum file descriptor limit: $MAX_FD"
        fi
    else
        warn "Could not query maximum file descriptor limit: $MAX_FD_LIMIT"
    fi
fi

# For Darwin, add options to specify how the application appears in the dock
if $darwin; then
    GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$APP_NAME\" \"-Xdock:icon=$APP_HOME/media/gradle.icns\""
fi

# For Cygwin, switch paths to Windows format before running java
if $cygwin ; then
    APP_HOME=`cygpath --path --mixed "$APP_HOME"`
    CLASSPATH=`cygpath --path --mixed "$CLASSPATH"`

    # We build the pattern for arguments to be converted via cygpath
    ROOTDIRSRAW=`find -L / -maxdepth 1 -mindepth 1 -type d 2>/dev/null`
    SEP=""
    for dir in $ROOTDIRSRAW ; do
        ROOTDIRS="$ROOTDIRS$SEP$dir"
        SEP="|"
    done
    OURCYGPATTERN="(^($ROOTDIRS))"
    # Add a user-defined pattern to the cygpath arguments
    if [ "$GRADLE_CYGPATTERN" != "" ] ; then
        OURCYGPATTERN="$OURCYGPATTERN|($GRADLE_CYGPATTERN)"
    fi
    # Now convert the arguments - kludge to limit ourselves to /bin/sh
    i=0
    for arg in "$@" ; do
        CHECK=`echo "$arg"|egrep -c "$OURCYGPATTERN" -`
        CHECK2=`echo "$arg"|egrep -c "^-"`                                 ### Determine if an option

        if [ $CHECK -ne 0 ] && [ $CHECK2 -eq 0 ] ; then                    ### Added a condition
            eval `echo args$i`=`cygpath --path --ignore --mixed "$arg"`
        else
            eval `echo args$i`="\"$arg\""
        fi
        i=$((i+1))
    done
    case $i in
        (0) set -- ;;
        (1) set -- "$args0" ;;
        (2) set -- "$args0" "$args1" ;;
        (3) set -- "$args0" "$args1" "$args2" ;;
        (4) set -- "$args0" "$args1" "$args2" "$args3" ;;
        (5) set -- "$args0" "$args1" "$args2" "$args3" "$args4" ;;
        (6) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" ;;
        (7) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" ;;
        (8) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" "$args7" ;;
        (9) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" "$args7" "$args8" ;;
    esac
fi

# Split up the JVM_OPTS And GORM_SHARE_OPTS values into an array, following the shell quoting and substitution rules
function splitJvmOpts() {
    JVM_OPTS=("$@")
}
eval splitJvmOpts $DEFAULT_JVM_OPTS $JAVA_OPTS $GORM_SHARE_OPTS
echo "Here is classpath"
echo $CLASSPATH

exec groovysh "${JVM_OPTS[@]}" -classpath "$CLASSPATH" 
