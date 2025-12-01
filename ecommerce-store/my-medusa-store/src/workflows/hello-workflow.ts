 import {
    createStep,
    createWorkflow,
    StepResponse,
    WorkflowResponse,
  } from "@medusajs/framework/workflows-sdk"

  /**
   * Step 1: Validate input
   */
  const validateInputStep = createStep(
    "validate-input",
    async (input: { name: string }) => {
      if (!input.name || input.name.length < 2) {
        throw new Error("Name must be at least 2 characters")
      }

      console.log("✅ Step 1: Input validated")

      return new StepResponse({ validatedName: input.name })
    }
  )

  /**
   * Step 2: Process data
   */
  const processDataStep = createStep(
    "process-data",
    async (input: { validatedName: string }) => {
      const greeting = `Hello, ${input.validatedName}!`
      const timestamp = new Date().toISOString()

      console.log("✅ Step 2: Data processed")

      return new StepResponse({ greeting, timestamp })
    }
  )

  /**
   * Workflow: Kết hợp các steps
   */
  export const helloWorkflow = createWorkflow(
    "hello-workflow",
    (input: { name: string }) => {
      // Step 1
      const { validatedName } = validateInputStep(input)

      // Step 2 (dùng kết quả từ step 1)
      const result = processDataStep({ validatedName })

      return new WorkflowResponse(result)
    }
  )