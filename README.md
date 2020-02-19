# Batch-Systems-OS-
CSEN 602 Operating Systems, Spring 2020 .

Batch processing => is a technique in which an Operating System collects similar
jobs together in a batch and then starts executing the batches sequentially, one
job at a time. In a multi-programmed batch system, the CPU will never be
idle. The Operating System keeps multiple jobs in the main memory, these are
the jobs waiting to be executed. The Operating System will choose one of these
jobs and begins execution. Once this job needs an I/O operation, the Operating
System switches to another job. If several jobs are ready to run at the same time,
then the Operating System chooses which one to run through the process of CPU
Scheduling.
