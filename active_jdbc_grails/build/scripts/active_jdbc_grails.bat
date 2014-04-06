@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  active_jdbc_grails startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and ACTIVE_JDBC_GRAILS_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\active_jdbc_grails.jar;%APP_HOME%\lib\slf4j-api-1.7.6.jar;%APP_HOME%\lib\groovy-all-2.1.0.jar;%APP_HOME%\lib\activejdbc-1.4.1.jar;%APP_HOME%\lib\activejdbc-instrumentation-1.4.1.jar;%APP_HOME%\lib\mysql-connector-java-5.0.4.jar;%APP_HOME%\lib\javalite-common-1.4.1.jar;%APP_HOME%\lib\maven-plugin-api-2.0.jar;%APP_HOME%\lib\javassist-3.8.0.GA.jar;%APP_HOME%\lib\maven-project-3.0-alpha-2.jar;%APP_HOME%\lib\slf4j-simple-1.5.10.jar;%APP_HOME%\lib\junit-4.8.2.jar;%APP_HOME%\lib\maven-model-3.0-alpha-2.jar;%APP_HOME%\lib\plexus-utils-1.5.6.jar;%APP_HOME%\lib\plexus-interpolation-1.1.jar;%APP_HOME%\lib\maven-compat-3.0-alpha-2.jar;%APP_HOME%\lib\plexus-container-default-1.0-beta-3.0.5.jar;%APP_HOME%\lib\wstx-asl-3.2.6.jar;%APP_HOME%\lib\model-builder-1.3.jar;%APP_HOME%\lib\maven-project-builder-3.0-alpha-2.jar;%APP_HOME%\lib\plexus-component-annotations-1.0-beta-3.0.5.jar;%APP_HOME%\lib\wagon-provider-api-1.0-beta-4.jar;%APP_HOME%\lib\plexus-classworlds-1.4.jar;%APP_HOME%\lib\xbean-reflect-3.4.jar;%APP_HOME%\lib\google-collect-snapshot-20080530.jar;%APP_HOME%\lib\stax-api-1.0.1.jar;%APP_HOME%\lib\log4j-1.2.12.jar;%APP_HOME%\lib\commons-logging-api-1.1.jar

@rem Execute active_jdbc_grails
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %ACTIVE_JDBC_GRAILS_OPTS%  -classpath "%CLASSPATH%" org.codehaus.groovy.tools.shell.Main %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable ACTIVE_JDBC_GRAILS_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%ACTIVE_JDBC_GRAILS_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
