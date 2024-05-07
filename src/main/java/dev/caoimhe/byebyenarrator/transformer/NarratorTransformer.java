package dev.caoimhe.byebyenarrator.transformer;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

public class NarratorTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (!name.equals("com.mojang.text2speech.Narrator")) {
            return bytes;
        }

        System.out.println("Transforming com.mojang.text2speech.Narrator...");

        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept(classNode, ClassReader.EXPAND_FRAMES);

        MethodNode getNarratorMethod = null;
        for (MethodNode methodNode : classNode.methods) {
            if (methodNode.name.equals("getNarrator")) {
                getNarratorMethod = methodNode;
                break;
            }
        }

        if (getNarratorMethod == null) {
            System.err.println("Failed to find getNarrator in com.mojang.text2speech.Narrator");
            return bytes;
        }

        getNarratorMethod.instructions.clear();
        getNarratorMethod.localVariables.clear(); // shouldn't be needed, but still nice.
        getNarratorMethod.instructions.add(generateGetNarratorInstructions());

        final ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(writer);

        System.out.println("Finished transforming com.mojang.text2speech.Narrator! Bye bye narrator!");

        return writer.toByteArray();
    }

    private InsnList generateGetNarratorInstructions() {
        InsnList list = new InsnList();

        list.add(new TypeInsnNode(Opcodes.NEW, "dev/caoimhe/byebyenarrator/DummyNarrator"));
        list.add(new InsnNode(Opcodes.DUP));
        list.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "dev/caoimhe/byebyenarrator/DummyNarrator", "<init>", "()V", false));
        list.add(new InsnNode(Opcodes.ARETURN));

        return list;
    }
}
