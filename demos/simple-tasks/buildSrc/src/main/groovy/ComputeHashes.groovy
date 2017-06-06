import java.security.MessageDigest
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.DefaultTask

class ComputeHashes extends DefaultTask {
    
    @Input
    String algo

    @InputFile
    def File noms

    @OutputFile
    def File getHash() {
        return new File("${noms.name}.${algo.toLowerCase()}")
    }

    @TaskAction
    void action() {
        hash.delete()
        hash << MessageDigest.getInstance(algo).digest(noms.text.bytes).encodeHex().toString()
    }
}