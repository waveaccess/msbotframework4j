@REM Maven Wrapper script for bumping version up
@REM ----------------------------------------------------------------------------

@echo off

echo Bumping version to %1

call mvnw.cmd versions:set -DnewVersion=%1
call mvnw.cmd -f msbotframework4j-dependencies\pom.xml versions:set -DnewVersion=%1

echo Finished
