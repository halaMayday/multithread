package com.example.demo.common;

import lombok.Builder;
import lombok.Data;

/**
 * .
 *
 * @author ：hf
 * @date ：Created in 2021/8/10 11:04
 */
@Data
@Builder
public class Punishment {

    private int leftCopyCount;
    private String wordToCopy;
}
