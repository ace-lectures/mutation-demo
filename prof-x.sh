#!/usr/bin/env bash

ORIGINAL=$1
HOW_MANY_MUTANTS=$2
HOW_MANY_MUTATIONS=$3

function main()
{
  prepare_environment
  prepare_mutants
  run_tests_on_mutants
  extract_results
}

function prepare_environment()
{
  rm -rf spooned mutants;
  mkdir -p mutants
}

function prepare_mutants()
{
  echo -e "# Preparing Mutants \n"
  echo "ID, Mutation, File, Line, Column"
  for id in $(seq 1 $HOW_MANY_MUTANTS)
  do
    prepare_a_mutant $id
  done
}

function prepare_a_mutant() # $1: mutant id
{
  cp -r $ORIGINAL "mutants/mutant_$1"
  rm -rf mutants/mutant_$1/src/main/java/*
  mvn -q exec:java -Dexec.args="$ORIGINAL $HOW_MANY_MUTATIONS mutants/mutant_$1" 2> /dev/null
  mv spooned/* mutants/mutant_$1/src/main/java/.
  rm -rf spooned
}

function run_tests_on_mutants()
{
  echo -e "\n# Testing Mutants"
  for m in mutants/mutant_*
  do
    cd $m || exit 1
    echo "## Processing $m"
    mvn -q clean test > /dev/null 2>&1
    cd $OLDPWD || exit 1
  done
}

function extract_results()
{
  echo -e "# Extracting results \n"

  # Set length of the "Mutation:" column
  # can be possibly computed automatically
  LENGTH=15

  # Print headers for results
  printf "%-*s %-10s%-10s%-10s%-10s\n" $LENGTH "Mutation:" "Tests" "Failures" "Errors" "Skipped"

  # Extract results from each mutation
  for m in mutants/mutant_*
  do
    cd $m || exit 1

    # Print the result of each mutation
    awk -v mut=$m -v len=$LENGTH -f awk_prog `find target/surefire-reports -name '*.txt'`
    cd $OLDPWD || exit 1
  done
}


main
