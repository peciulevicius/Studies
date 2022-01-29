import os

# The top argument for walk
topdir = 'C:/Users/Dziug/OneDrive/Desktop/CODE/Algorithms-And-Data-Structures-Classwork'
# The extension to search for
exten = '.py'
logname = 'TASK 3 findfiletype.txt'
# What will be logged
results = str()

for dirpath, dirnames, files in os.walk(topdir):
    for name in files:
        if name.lower().endswith(exten):
            # Save to results string instead of printing
            results += '%s\n' % os.path.join(dirpath, name)

# Write results to logfile
with open(logname, 'w') as logfile:
    logfile.write(results)