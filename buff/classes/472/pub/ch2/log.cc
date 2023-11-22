#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <sys/stat.h>

using namespace std;

#include "log.hh"
#include "csv.hh"
#include "err.h"

FILE* Log::f=0;

////////////////////////////////////////////////////////////////////////////
/// This method opens the log file.
////////////////////////////////////////////////////////////////////////////
void Log::open(int log, char* logfile) {
  if (!f && log) {
    if (!(f=fopen(logfile,"a")))
      ERR("Log::open(): fopen() failed: %s",strerror(errno));
    if (fchmod(fileno(f),S_IRUSR|S_IWUSR|S_IRGRP|S_IROTH))
      ERR("Log::open(): fchmod() failed: %s",strerror(errno));
  }
}

////////////////////////////////////////////////////////////////////////////
/// This method writes a CSV entry to the log file.
////////////////////////////////////////////////////////////////////////////
void Log::log(char* msg[]) {
  if (f) {
    CSV csv(msg);
    char* s=csv.line();
    fputs(s,f);
    free(s);
  }
}

////////////////////////////////////////////////////////////////////////////
/// This method closes the log file.
////////////////////////////////////////////////////////////////////////////
void Log::close() {
  if (f)
    fclose(f);
  f=0;
}
