- [ ] **ConnectionBlock.java Optimizations**
    - [ ] Consider creating objects in batches, if feasible and if creating each `Connection` object individually in `createConnections` method is resource-intensive. (Note: Usually done in context of databases or APIs)
    - [ ] If dealing with a large number of neurons, look into parallel streams or implementing some parallelism in your `processNeurons` or `propagate` methods.
      ```java
      public List<Double> processNeurons() {
        // Note: Assumes a method called `process` in `Neuron` class 
        return neurons.parallelStream()
                      .map(Neuron::process)
                      .collect(Collectors.toList());
      }
      ```
    - [ ] If `propagate` method involves calculations over pairs of neurons, consider using efficient data structures like a `Map` for access, instead of nested lists.

- [ ] **Main.java Optimizations**
    - [ ] Reuse values such as `input_l1.get_Output_Layer()` instead of calling these methods multiple times, where applicable.
    - [ ] Assess whether the layers need to be processed separately or processing could be done within one block, which could significantly simplify your `Main` method.

- [ ] **General Notes**
    - [ ] Bottlenecks refer to sections of your code that limit its performance. Identify these and focus your optimizations there.
    - [ ] Profile the code to identify bottlenecks (use profiler tools to do this), and optimise accordingly.
    - [ ] Implement different approaches and conduct functional tests with control data to check for efficiency and correctness.
    - [ ] Over-optimization can lead to difficult-to-maintain code. Find the balance between efficiency and readability/maintainability.