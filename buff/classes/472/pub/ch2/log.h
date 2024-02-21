// static idea of Singleton(127)

////////////////////////////////////////////////////////////////////////////
/// This class writes CSV messages to a log file, iff logging is
/// enabled by the "log" argument of the "open" function, which
/// probably is the value of a command-line argument.
/// 
/// It (safely) assumes that the underlying file descriptor
/// ensures serialized writes.
////////////////////////////////////////////////////////////////////////////

#ifndef LOG_HH
#define LOG_HH

#include <stdio.h>

class Log {
  static FILE* f;
  Log() {}
public:
  static void open(int log, char* logfile);
  static void log(char* msg[]);
  static void close();
};

#endif // LOG_HH
