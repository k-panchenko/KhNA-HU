/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_5.application;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author student
 */
public class Program {
    public static void main(String[] args) {
        var liveMap = Map.of(
                AppleTree.class, 30,
                CherryTree.class, 40,
                PearTree.class, 20
        );
        
        var random = new Random();
        var trees = IntStream.rangeClosed(5, 20)
                .mapToObj(__ -> {
                    var age = random.nextInt(100 - 10 + 1) + 10;
                    GardenTree tree;
                    switch (random.nextInt(3)) {
                        case 0:
                            tree = new AppleTree(age);
                            break;
                        case 1:
                            tree = new CherryTree(age);
                            break;
                        case 2: 
                            tree = new PearTree(age);
                            break;
                        default:
                            throw new RuntimeException();
                    }
                    return tree;
                })
                .collect(Collectors.toList());
        for (var tree : trees) {
            System.out.printf("%s %s\n",
                    tree,
                    tree.getAge() > liveMap.get(tree.getClass())
                            ? "нужно пересаживать"
                            : "не нужно пересаживать");
        }
    }
}

@Data
abstract class GardenTree {
    private final Integer age;
}

@ToString(callSuper = true)
class AppleTree extends GardenTree {

    public AppleTree(Integer age) {
        super(age);
    }
    
}
@ToString(callSuper = true)
class CherryTree extends GardenTree {

    public CherryTree(Integer age) {
        super(age);
    }
    
}
@ToString(callSuper = true)
class PearTree extends GardenTree {

    public PearTree(Integer age) {
        super(age);
    }
    
}

