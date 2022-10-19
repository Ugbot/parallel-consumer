# Pyallel Consumer

Python wrapper for [Confluent Parallel Consumer](https://github.com/confluentinc/parallel-consumer).

## Usage

This library starts the JVM and makes Java packages beginning with `io` available under the alias `jio` (to avoid conflicts with the std-lib `io.py` module).

You can import the parallel consumer Java package as a Python package.
All parallel consumer classes and functions are accessible from this, with support for passing Python objects as arguments including functions.

```python
from jio.confluent.parallelconsumer import ParallelConsumerOptions, ParallelStreamProcessor
...
options = ParallelConsumerOptions.builder() \
        .ordering(ParallelConsumerOptions.ProcessingOrder.KEY) \
        .maxConcurrency(1000) \
        .consumer(consumer) \
        .producer(producer) \
        .build()
processor = ParallelStreamProcessor.createEosStreamProcessor(options)
processor.subscribe([topic])
processor.poll(lambda o: print(f"Concurrently processing a record: {o}"))
```

Check out the `examples` folder for a full working example.

To run an example call the script e.g. `python ./examples/parallel_consumption.py`

## How Does it Work?

This package depends on [JPype](https://jpype.readthedocs.io/en/latest/index.html) to provide an interface between
Python and Java.

The most popular versions of the JVM and the Python Interpreter (aka Python Virtual Machine) are written in C.
Python code can therefore execute C code, which can execute Java code by invoking the 
[JNI](https://en.wikipedia.org/wiki/Java_Native_Interface) (Java Native Interface).

JPype provides a powerful API on top of this C binding.

## Developer Setup

### Setup Python Environment

Recommended (but can use other tools such as .venv):

- Install [Miniconda](https://docs.conda.io/projects/conda/en/latest/user-guide/install/index.html)
- Create a new python environment `conda create -n pyallel python=3.10`
- Active your environment `conda activate pyallel`

### Install Package in Editable Mode

- `pip install -e .`